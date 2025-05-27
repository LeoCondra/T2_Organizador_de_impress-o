import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        int stat = -1;
        Scanner scanner=new Scanner(System.in);
        Fila fila=new Fila();
        Pilha pilha=new Pilha();

        Documento doc;
        
        String nomeA;
        String nomeU;
        
        while(stat!=0){
            System.out.println("\n1-Adcionar documento\n2-Imprimir documento\n3-Procurar Documento\n4-Adcionar documento a pilha de prioridade\n5-Imprimir documento pilha de prioriade\n6-Procurar documento na pilha de prioridade\n7-Mostrar a fila de Impressao\n8-Mostrar a pilha de impressao\n0- Sair\n");
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
                    doc=new Documento(nomeU, nomeA);
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
                case 4:
                    if(pilha.pilhaCheia()){
                        System.out.println("Pilha de prioridade cheia");
                        break;
                    }
                    System.out.println("Insira o nome do arquivo:");
                    nomeA = scanner.nextLine();
                    System.out.println("Insira nome do Usuario:");
                    nomeU= scanner.nextLine();
                    doc=new Documento(nomeU, nomeA);
                    pilha.push(doc);
                    break;
                case 5:
                    if(pilha.pilhaVazia()){
                            System.out.println("Nao ha documentos para imprimir na pilha de prioridade");
                    }else{
                        doc = pilha.pop();
                        doc.marcarFim(); 
                        System.out.println(doc);
                        System.out.println("O documento da pilha de prioridade foi impresso");
                    }  
                    break;
                case 6:
                    System.out.println("Qual o nome do arquivo que voce quer procurar?");
                    pilha.acharArquivo(scanner.nextLine());
                    break;
                case 7:
                    if(fila.filaVazia()){
                        System.out.println("Fila vazia");
                    }else{
                        System.out.println(fila);

                    }
                    break;
                
                case 8:
                    if(pilha.pilhaVazia()){
                        System.out.println("Pilha vazia");
                    }else{
                        System.out.println(pilha);
                    }
                    break;
                default:
                    System.out.println("Numero Invalido");
                    break;
            }
        }
        scanner.close();
    
    }
}
