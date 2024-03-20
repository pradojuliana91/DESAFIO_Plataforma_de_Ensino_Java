package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();
        List<Lesson> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i+1) + "a aula:");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine();
            String title = sc.nextLine();
            if(ch == 'c') {
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();

                Lesson lesson = new Video(title, url, seconds);
                list.add(lesson);
            }
            else {
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();

                Lesson lesson = new Task(title, description, questionCount);
                list.add(lesson);
            }
        }

        int sum = 0;
        for (Lesson lesson : list) {
            sum += lesson.duration();
        }

        System.out.println();
        System.out.printf("DURACAO TOTAL DO CURSO = " + sum + " segundos");


        sc.close();
    }
}