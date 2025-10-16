import java.util.Scanner;
import java.util.InputMismatchException;

public class Sistema {

    private static final String SIMULA_DATA = "15/10/2025";
    private static final String SIMULA_HORA = "13:00"; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaSolicitacoes solicitacoes = new PilhaSolicitacoes();

        System.out.println("######## INICIANDO SISTEMA ##########\n\n");
        boolean flag_sistema_ativo = true;

        int escolha_usuario;
        int criador_ids = 0;
        int confirmacao;
        do {

            try {

                System.out.println("\n-->Digite 1 para criar um novo procedimento\n"
                                    + "-->Digite 2 para imprimir o historico de solicitacoes\n"
                                    + "-->Digite 4 para encerrar o sistema");
                escolha_usuario = scanner.nextInt();
                scanner.nextLine();

                if (escolha_usuario == 4) {

                    flag_sistema_ativo = false;

                } else if (escolha_usuario == 2) {

                    solicitacoes.imprimirHistorico();

                } else if (escolha_usuario == 1) {

                    int id_solicitacao = criador_ids;
                    int id_cliente = criador_ids * 10;
                    String data_atual = SIMULA_DATA;
                    String hora_atual = SIMULA_HORA;
                    String descricao;

                    System.out.println("\nQual o motivo da solicitacao?");
                    descricao = scanner.nextLine();

                    solicitacoes.adicionarSolicitacao(id_solicitacao, descricao, data_atual, hora_atual);

                    boolean confirmado = false;
                    do {

                        System.out.println("\nDIGITE 1 PARA CONFIRMAR A OPERACAO E 2 PARA CANCELAR A OPERACAO E REVERTER AS MUDANCAS:");
                        confirmacao = scanner.nextInt();
                        scanner.nextLine();

                        if (confirmacao == 1) {
                            System.out.println("\nProcedimento adicionado ao sistema!!");
                            confirmado = true;
                        } else if (confirmacao == 2) {
                            solicitacoes.cancelarOperacao();
                            System.out.println("\nOperacao cancelada e excluida!");
                            confirmado = true;
                        } else {
                            System.out.println("\nOpcao invalida - tente novamente");
                        }

                    } while (!confirmado);
                    criador_ids ++;

                } else {

                    System.out.println("\nOpcao invalida - tente novamente");

                }

            } catch (InputMismatchException e){
                System.out.println("\nentrada invalida. por favor digite um valor valido");
                scanner.nextLine();
            }

        } while (flag_sistema_ativo);

        scanner.close();

    }

}