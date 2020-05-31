    /*
     * Classname Main
     *
     * Version info 1
     *
     * Copyright Vasylkivska Kateryna KNTEU
     *  */
package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

            public static void main(String[] args) throws IOException {
                String harry = new String(Files.readAllBytes(Paths.get("/Users/Kate/Downloads/harry.txt")));
                String harryCleaned = harry.replaceAll("[^a-zA-Z0-9' ]", "");
                String[] harryWords = harryCleaned.split(" ");
                String[] harryLines = harry.split("\\n");
                for (int i = 0; i < 10; i++) {

                    System.out.println(i+". " + harryLines[i]);
                    System.out.println();

                }
                //------------------------------------------------------------
                // 1.Ищем самое длинное слово
                String longesWord = "";
                for (int i = 0; i < harryWords.length ; i++) {
                    if (harryWords[i].length() > longesWord.length()){
                        longesWord = harryWords[i];
                    }

                }
                System.out.println(longesWord);
                //--------------------------------------------
                //2.Подсчитываем строки, где встречается слово Гарри
                int counter = 0;
                for (int i = 0; i < harryLines.length; i++) {
                    if(harryLines[i].contains("Harry")){
                        counter++;
                    }

                }
                System.out.println(counter);
                //---------------------------------------------
                //3.Cоздайте массив хеш-слов
                String distinctString = "";
                for (int i = 0; i < harryWords.length; i++) {
                    if(!distinctString.contains(harryWords[i])){
                        distinctString += harryWords[i] + " ";
                    }
                }
                String[] distinctArry = distinctString.split(" ");
                System.out.println(distinctArry.length);
                System.out.println(harryWords.length);
                System.out.println("Всего слов " + harryWords.length + " с них дистинктов " + distinctArry.length + ".");

                Integer[] hashArry  = new Integer[distinctArry.length];
                for (int i = 0; i < distinctArry.length ; i++) {
                    hashArry[i] = distinctArry[i].hashCode();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println(distinctArry[i] + " - " + hashArry[i]) ;

                }
                //---------------------------------------------------------------
                //4. Пересечение хешей
                for (int i = 0; i < hashArry.length ; i++) {
                    counter = 0;
                    for (int j = i+1; j <hashArry.length ; j++) {
                        if (hashArry[j]!=null){
                            if (hashArry[i] == hashArry[j]){
                                counter++;
                                hashArry[j]=null;
                            }

                        }

                    }
                    if (counter!=0){
                        System.out.println(hashArry[i]+ " - " + counter);
                    }
                }
                System.out.println(counter);

            }
        }
