import java.io.*;
import java.net.*;

class Servidor
{
   private static int portaServidor = 6789;

   //Criptografa a mensagem recebida por meio do ciframento de césar com chave igual a 3
   public static String cifraString(String str){
		String str2="";
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
         int i2=ch+3;
			str2+=(char)i2; 
		}
		return str2;
	}

   public static void main(String argv[]) throws Exception
   {
      //Efetua as primitivas socket e bind
      ServerSocket socket = new ServerSocket(portaServidor);

      while(true)
      {
         //Efetua a primitiva accept
         Socket conexao = socket.accept();

         //Efetua a primitiva receive
         System.out.println("Aguardando datagrama do cliente....");
         BufferedReader entrada =  new BufferedReader(new InputStreamReader(conexao.getInputStream()));

         //Operacao com os dados recebidos e preparacao dos a serem enviados
         String str = entrada.readLine();
         System.out.println("Mensagem recebida para executar criptografia: " + str);

         str = cifraString(str) + '\n';

         //Efetua a primitiva send
         DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
         saida.writeBytes(str);
         System.out.println("Enviado...");

         conexao.close();
      }
   }
}
