package controllers;

import domain.NovaPessoaJob;
import domain.repositories.Repositorio;
import play.Logger;
import play.libs.F;
import play.mvc.Http;
import play.mvc.WebSocketController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class WebSocket extends WebSocketController {

    public static void trocaDeMensagem(){
        while(inbound.isOpen()){
            System.out.println("funfando");
            Http.WebSocketEvent e = await(inbound.nextEvent());
            if(e instanceof Http.WebSocketFrame) {
                Http.WebSocketFrame frame = (Http.WebSocketFrame) e;
                System.out.println(frame.textData);
                if(!frame.isBinary) {
                    if(frame.textData.equals("quit")) {
                        outbound.send("Bye!");
                        disconnect();
                    } else {
                        outbound.send("Echo: %s", frame.textData);
                    }
                }
            }
            if(e instanceof Http.WebSocketClose) {
                Logger.info("Socket closed!");
            }
        }
    }

    private final Repositorio repositorio = new Repositorio();

    public void listagem(){

        while(inbound.isOpen()){
            await("2s");

            int total = repositorio.buscarTodasPessoas().size();

            outbound.send("Total de pessoas: " + total);

            if(total >= 10000) {
                outbound.send("Fim");
                disconnect();
            }

        }
    }

}
