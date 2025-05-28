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

        System.out.println("\n<T2- Ordenador de Impressao>\n");
        
        while(stat!=0){
            System.out.println("\nDigite os numeros no terminal que correspodem ao comando desejado \n<1> - Adcionar documento\n<2> - Imprimir documento\n <3> - Procurar Documento\n<4> - Adcionar documento a pilha de prioridade\n<5> - Imprimir documento pilha de prioriade\n<6> - Procurar documento na pilha de prioridade\n<7> - Mostrar a fila de Impressao\n<8> - Mostrar a pilha de impressao\n<0> - Sair\n");
            stat=scanner.nextInt();
            scanner.nextLine();

            switch (stat) {
                case 0:
                    System.out.println("\nAte logo");
                    break;
                case 1:
                    if(fila.filaCheia()){
                        System.out.println("\nA fila esta cheia, volte novamente mais tarde :D");
                        break;
                    }
                    System.out.println("\nInsira o nome do arquivo:");
                    nomeA = scanner.nextLine();
                    System.out.println("\nInsira nome do Usuario:");
                    nomeU= scanner.nextLine();
                    doc=new Documento(nomeU, nomeA);
                    fila.enfileira(doc);
                    break;
                case 2:
                    if(fila.filaVazia()){
                        System.out.println("\nNao ha documentos para imprimir");
                    }else{
                        doc = fila.desenfileira();
                        doc.marcarFim(); 
                        System.out.println(doc);
                        System.out.println("\nO documento foi impresso");
                    }
                    break;
                case 3:
                    System.out.println("\nQual o nome do arquivo que voce quer procurar?");
                    fila.acharArquivo(scanner.nextLine());
                    break;
                case 4:
                    if(pilha.pilhaCheia()){
                        System.out.println("\nPilha de prioridade cheia");
                        break;
                    }
                    System.out.println("\nInsira o nome do arquivo:");
                    nomeA = scanner.nextLine();
                    System.out.println("\nInsira nome do Usuario:");
                    nomeU= scanner.nextLine();
                    doc=new Documento(nomeU, nomeA);
                    pilha.push(doc);
                    break;
                case 5:
                    if(pilha.pilhaVazia()){
                            System.out.println("\nNao ha documentos para imprimir na pilha de prioridade");
                    }else{
                        doc = pilha.pop();
                        doc.marcarFim(); 
                        System.out.println(doc);
                        System.out.println("\nO documento da pilha de prioridade foi impresso");
                    }  
                    break;
                case 6:
                    System.out.println("\nQual o nome do arquivo que voce quer procurar?");
                    pilha.acharArquivo(scanner.nextLine());
                    break;
                case 7:
                    if(fila.filaVazia()){
                        System.out.println("\nFila vazia");
                    }else{
                        System.out.println(fila);

                    }
                    break;
                case 8:
                    if(pilha.pilhaVazia()){
                        System.out.println("\nPilha vazia");
                    }else{
                        System.out.println(pilha);
                    }
                    break;
                default:
                    System.out.println("\nNumero Invalido");
                    break;
            }
        }
        scanner.close();
    
    }
}
