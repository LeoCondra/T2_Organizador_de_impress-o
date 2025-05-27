import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        int stat = -1;
        Scanner scanner=new Scanner(System.in);
        Fila fila=new Fila();
        
        String nomeA;
        String nomeU;
        

        while(stat!=0){
            System.out.println("1-Adcionar documento\n2-Imprimir documento\n3-Procurar Documento\n0- Sair\n");
            stat=scanner.nextInt();
            scanner.nextLine();

            switch (stat) {
                case 0:
                    System.out.println("Ate logo");
                    break;
                case 1:
                    if(fila.filaCheia()){
                        System.out.println("A fila esta cheia, volte novamente mais tarde :D");
                        break;
                    }
                    System.out.println("Insira o nome do arquivo:");
                    nomeA = scanner.nextLine();
                    System.out.println("Insira nome do Usuario:");
                    nomeU= scanner.nextLine();
                    Documento doc=new Documento(nomeU, nomeA);
                    fila.enfileira(doc);
                    break;
                case 2:
                    if(fila.filaVazia()){
                        System.out.println("Nao ha documentos para imprimir");
                    }else{
                        doc = fila.desenfileira();
                        doc.marcarFim(); 
                        System.out.println(doc);
                        System.out.println("O documento foi impresso");
                    }
                    break;
                case 3:
                    System.out.println("Qual o nome do arquivo que voce quer procurar?");
                    fila.acharArquivo(scanner.nextLine());
                    break;
                default:
                    System.out.println("Numero Invalido");
                    break;
            }
        }
        scanner.close();
    
    }
}
