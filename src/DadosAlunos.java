import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DadosAlunos {
    Scanner scn = new Scanner(System.in);
    ArrayList<Aluno> listaAlunos = new ArrayList<>();

    // MÉTODOS DA CLASSE
    public void adicionarAluno() {
        try {
            // RECEBENDO INFORMAÇÕES DA NOVA PESSOA
            System.out.print("Nome do novo aluno: ");
            scn.nextLine();
            String nomeNovoAluno = scn.nextLine();

            System.out.print("Idade do novo aluno: ");
            int idadeNovoAluno = scn.nextInt();
            scn.nextLine();

            ArrayList<Curso> listaCursosNovoAluno = new ArrayList<>();

            // INSTANCIANDO OBJETO e ADICIONANDO À LISTA
            listaAlunos.add(new Aluno(nomeNovoAluno, idadeNovoAluno, listaCursosNovoAluno, StatusMatricula.ATIVO));

            // FEEDBACK AO USUÁRIO
            System.out.println("*" + nomeNovoAluno.toUpperCase() + " foi adicionado à lista* \n");
        } catch (InputMismatchException e) {
            System.err.println("Erro de entrada. Por favor, insira um número para a idade.");
            scn.nextLine();
        } finally {
        }
    }

    public void removerAluno(int indexAluno) {
        try {
            listaAlunos.remove(indexAluno);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("O índice ndice fornecido está fora do intervalo. Não foi possível remover o aluno.");
        }
    }

    public void buscarAluno(int idAluno) {
        try {
            if (idAluno >= 0 && idAluno < listaAlunos.size()) {
                System.out.println("Resultado da busca para o ID " + idAluno + ":");
                System.out.println(listaAlunos.get(idAluno));
            } else {
                throw new IllegalArgumentException("ID fornecido é inválido.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Não foi possível localizar um aluno com a ID " + idAluno + " em nosso sistema.");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("DadosAlunos:\n");
        for (Aluno aluno : listaAlunos) {
            result.append(aluno.toString());
        }
        return result.toString();
    }
    @Override
    public String toString() {
        String result = "DadosAlunos:\n";
        for (Aluno aluno : listaAlunos) { // Correção aplicada aqui
            result += aluno.toString();
        }
        return result;
    }
}

