import java.io.*;
import java.net.*;

class Cliente
{
   private static int portaServidor = 6789;

   public static String lerString () throws Exception {
      System.out.println("Insira a mensagem que deseja criptografar");
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      return in.readLine();
   }

   public static void main(String argv[]) throws Exception
   {
      //Efetua a primitiva socket
      Socket socket = new Socket("192.168.1.106", portaServidor);

      //Efetua a primitiva send
      DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
      saida.writeBytes(lerString() + '\n');


      //Efetua a primitiva receive
      BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      System.out.println("Mensagem criptografada recebida do servidor: " + entrada.readLine());

      //Efetua a primitiva close
      socket.close();
   }
}
