package controllers;

import domain.NovaPessoaJob;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.F;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class AsyncTest extends Controller {

    @Transactional
    public static void processar(){

        List<F.Promise<Integer>> promises = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
           // for(int y = 0; y < 50; y++) {
                String nomeAleatorio = "Nova Pessoa" + i;
                promises.add(new NovaPessoaJob(nomeAleatorio).afterRequest());
          //  }
           // response.writeChunk(i);
        }
        System.out.println("percorreu todo o laço");
        await(F.Promise.waitAll(promises), result -> {
            System.out.println("Aguardar todas");
            for(int i = 0; i < 10000; i++) {
                System.out.println(i);
            }
        });

        ok();
    }

    public static void loopWithoutBlocking() {
        for(int i=0; i<=10; i++) {
            System.out.println(i);
            await("1s");
        }
        renderText("Loop finished");
    }
}
