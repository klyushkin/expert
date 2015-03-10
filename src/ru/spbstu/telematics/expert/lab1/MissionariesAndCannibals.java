/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spbstu.telematics.expert.lab1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alexandr
 */
public class MissionariesAndCannibals {

    public static int countMissionaries = 2;
    public static int countCannibals = 2;

    private static ArrayList<Station> stations = new ArrayList<>();

    private static Boolean checkStation(Station station) {
        Station fin = new Station(0, 0, 1);
        for (int i = 0; i < stations.size(); i++) {
            if (station.compare(stations.get(i))) {
                return false;
            }
        }

        if (station.missionaries >= 0 && station.missionaries <= countMissionaries && ((station.missionaries >= station.cannibals) || station.missionaries == 0)
                && (((countMissionaries - station.missionaries) >= (countCannibals - station.cannibals)) || (countMissionaries - station.missionaries == 0)) && station.bank >= 0 && station.bank <= 1
                && station.cannibals >= 0 && station.cannibals <= countCannibals) {
            if (station.compare(fin)) {
                return true;
            }
            stations.add(station);
            return true;
        }
        return false;
    }

    private static Station moveTwoMissionaries(Station station) {
        Station tmp = new Station(station);
        if (tmp.bank == 0) {
            tmp.missionaries = tmp.missionaries - 2; // перевозим двоих вправо
            tmp.bank++;
        } else {
            tmp.missionaries = tmp.missionaries + 2;
            tmp.bank--;
        }

        return tmp;
    }

    private static Station moveOneMissionar(Station station) {
        Station tmp = new Station(station);
        if (tmp.bank == 0) {
            tmp.missionaries = tmp.missionaries - 1; // перевозим двоих вправо
            tmp.bank++;
        } else {
            tmp.missionaries = tmp.missionaries + 1;
            tmp.bank--;
        }

        return tmp;
    }

    private static Station moveTwoCannibals(Station station) {
        Station tmp = new Station(station);

        if (tmp.bank == 0) {
            tmp.cannibals = tmp.cannibals - 2; // перевозим двоих вправо
            tmp.bank++;
        } else {
            tmp.cannibals = tmp.cannibals + 2;
            tmp.bank--;
        }

        return tmp;
    }

    private static Station moveOneCannibal(Station station) {
        Station tmp = new Station(station);
        if (tmp.bank == 0) {
            tmp.cannibals = tmp.cannibals - 1; // перевозим двоих вправо
            tmp.bank++;
        } else {
            tmp.cannibals = tmp.cannibals + 1;
            tmp.bank--;
        }

        return tmp;
    }

    private static Station moveOneMissionarOneCannibal(Station station) {
        Station tmp = new Station(station);
        if (tmp.bank == 0) {
            tmp.cannibals = tmp.cannibals - 1;
            tmp.missionaries = tmp.missionaries - 1;
            tmp.bank++;
        } else {
            tmp.cannibals = tmp.cannibals + 1;
            tmp.missionaries = tmp.missionaries + 1;
            tmp.bank--;
        }

        return tmp;
    }

    private static ArrayList<Station> actions(Station station) {
        ArrayList<Station> preStation = new ArrayList<>();
        if (checkStation(moveTwoMissionaries(station))) {
            preStation.add(moveTwoMissionaries(station));
        }
        if (checkStation(moveOneMissionarOneCannibal(station))) {
            preStation.add(moveOneMissionarOneCannibal(station));
        }
        if (checkStation(moveTwoCannibals(station))) {
            preStation.add(moveTwoCannibals(station));
        }
        if (checkStation(moveOneMissionar(station))) {
            preStation.add(moveOneMissionar(station));
        }
        if (checkStation(moveOneCannibal(station))) {
            preStation.add(moveOneCannibal(station));
        }

        //  System.out.println(preStation);
        return preStation;
    }

    private void bfd() {
        Boolean fl = true;
        Station startStation = new Station(countMissionaries, countCannibals, 0);
        stations.add(startStation);
        // actions(startStation);

        ArrayList<ArrayList<Station>> path = new ArrayList<>();
        ArrayList<Station> branch = new ArrayList<>();

        branch.add(startStation);
        path.add(branch);

        Station fin = new Station(0, 0, 1);

        int step = 0;
        while (!path.isEmpty()) {
            ArrayList<ArrayList<Station>> tmpPath = new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                ArrayList<Station> tmp = new ArrayList<>();

                tmp = actions(path.get(i).get(path.get(i).size() - 1)); // берем последний узел ветви
                for (int j = 0; j < tmp.size(); j++) {
                    ArrayList<Station> tmpBranch = new ArrayList<>(path.get(i));
                    tmpBranch.add(tmp.get(j));
                    tmpPath.add(tmpBranch);
                }
            }
            path = new ArrayList<>(tmpPath);
 //           System.out.println("Step " + step);
   //         System.out.println(path);
            step++;
            int last = 0;
            while (last < path.size()) {
                if (path.get(last).get(path.get(last).size() - 1).compare(fin)) {
                    System.out.println("\nРешение " + path.get(last));
                    fl = false;
                    path.remove(last);
                    last--;

                }
                last++;
            }
        }
        if (fl) System.out.println("Решения нет!");
    }

    private static void inputCountMissionaries() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Количество миссионеров: ");
            countMissionaries = scan.nextInt();
            if (countMissionaries < 0) {
                System.out.println("Ошибка, повторите ввод");
                inputCountMissionaries();
            }
        } catch (InputMismatchException e) {

            System.out.println("Ошибка, повторите ввод");
            inputCountMissionaries();
        }

    }

    private static void inputCountCannibals() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Количество каннибалов: ");
            countCannibals = scan.nextInt();
            if (countCannibals < 0) {
                System.out.println("Ошибка, повторите ввод");
                inputCountCannibals();
            }
        } catch (InputMismatchException e) {

            System.out.println("Ошибка, повторите ввод");
            inputCountCannibals();
        }

    }

    public static void main(String[] args) {
        // TODO code application logic herestation.missionaries > 0
        System.out.println("!==== Миссионеры и каннибалы v1.0 ====!");
        System.out.println("1. Задать количесто участников");
        System.out.println("0. Выход");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        while (true) {

            
            switch (s) {
                case "1": {
                    MissionariesAndCannibals obj = new MissionariesAndCannibals();
                    stations.clear();
                    inputCountMissionaries();
                    inputCountCannibals();
                    if (countMissionaries < countCannibals) {
                        System.out.println("Каннибалы съели миссионеров");
                        break;
                    }
                    obj.bfd();
                    break;

                }
                case "0":
                    return;
                default: {
                    System.out.println("Ошика ввода, повторите");
                    break;
                }

            }
            System.out.println("!==== Миссионеры и каннибалы v1.0 ====!");
            System.out.println("1. Задать количесто участников");
            System.out.println("0. Выход");
            s = scan.nextLine();
        }

    }

}
