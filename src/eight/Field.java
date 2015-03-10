/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eight;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author alexandr
 */
public class Field {
    /*
     123
     804
     765
    
     tmp=[1,2,3,8,0,4,7,6,5]
     */

    public ArrayList<ArrayList<ArrayList<Integer>>> path = new ArrayList<>();
    static public ArrayList<Integer> end = new ArrayList<>();

    public Field(ArrayList<Integer> startField) {
        //path.get(0).add(startField);
        end.add(1);
        end.add(2);
        end.add(3);
        end.add(8);
        end.add(0);
        end.add(4);
        end.add(7);
        end.add(6);
        end.add(5);
    }

    static private ArrayList<ArrayList<Integer>> fisrtState(ArrayList<Integer> field) {
        /*
         023
         456
         781
        
         tmp = [0,2,3,4,5,6,7,8,1]
         */
        ArrayList<Integer> tmp = new ArrayList<>(field);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.swap(tmp, 0, 1);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 0, 4);
        result.add(tmp);
//        System.out.println("State 1 " + result);
        return result;

    }

    static private ArrayList<ArrayList<Integer>> secondState(ArrayList<Integer> field) {
        /*
         203
         456
         781
        
         */
        ArrayList<Integer> tmp = new ArrayList<>(field);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.swap(tmp, 0, 1);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 1, 2);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 1, 4);
        result.add(tmp);
//        System.out.println("State 2 " + result);
        return result;

    }

    static private ArrayList<ArrayList<Integer>> thirdState(ArrayList<Integer> field) {
        /*
         320
         456
         781
       
         */
        ArrayList<Integer> tmp = new ArrayList<>(field);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.swap(tmp, 2, 1);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 2, 5);
        result.add(tmp);
//        System.out.println("State 3 " + result);
        return result;

    }

    static private ArrayList<ArrayList<Integer>> fourthState(ArrayList<Integer> field) {
        /*
         423
         056
         781
        
         */
        ArrayList<Integer> tmp = new ArrayList<>(field);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.swap(tmp, 0, 3);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 3, 4);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 3, 6);
        result.add(tmp);
//        System.out.println("State 4 " + result);
        return result;

    }

    static private ArrayList<ArrayList<Integer>> fifthState(ArrayList<Integer> field) {
        /*
         423
         506
         781
         //field=[1,2,3,8,0,4,7,6,5]
         */
        ArrayList<Integer> tmp = new ArrayList<>(field);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.swap(tmp, 4, 1);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 4, 3);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 4, 5);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 4, 7);
        result.add(tmp);
//        System.out.println("State 5 " + result);
        return result;

    }

    static private ArrayList<ArrayList<Integer>> sixthState(ArrayList<Integer> field) {
        /*
         423
         560
         781
        
         */
        ArrayList<Integer> tmp = new ArrayList<>(field);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.swap(tmp, 5, 2);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 5, 4);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 5, 8);
        result.add(tmp);
//        System.out.println("State 6 " + result);
        return result;

    }

    static private ArrayList<ArrayList<Integer>> seventhState(ArrayList<Integer> field) {
        /*
         423
         567
         081
        
         */
        ArrayList<Integer> tmp = new ArrayList<>(field);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.swap(tmp, 6, 7);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 6, 3);
        result.add(tmp);
//        System.out.println("State 7 " + result);
        return result;

    }

    static private ArrayList<ArrayList<Integer>> eighthState(ArrayList<Integer> field) {
        /*
         423
         567
         801
        
         */
        ArrayList<Integer> tmp = new ArrayList<>(field);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.swap(tmp, 7, 6);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 7, 8);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 7, 4);
        result.add(tmp);
//        System.out.println("State 8 " + result);
        return result;

    }

    static private ArrayList<ArrayList<Integer>> ninthState(ArrayList<Integer> field) {
        /*
         423
         567
         810
        
         */
        ArrayList<Integer> tmp = new ArrayList<>(field);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Collections.swap(tmp, 8, 7);
        result.add(tmp);
        tmp = new ArrayList<>(field);
        Collections.swap(tmp, 8, 5);
        result.add(tmp);
//        System.out.println("State 9 " + result);
        return result;

    }

    static private ArrayList<ArrayList<Integer>> checkState(ArrayList<Integer> tmp) {
        int state = 10;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (!tmp.equals(end)) {

            for (int i = 0; i < tmp.size(); i++) {
                if (tmp.get(i) == 0) {
                    state = i;
                    break;
                }
            }

            switch (state) {
                case 0: {
                    result = new ArrayList<>(fisrtState(tmp));
                    break;
                }
                case 1: {
                    result = new ArrayList<>(secondState(tmp));
                    break;
                }
                case 2: {
                    result = new ArrayList<>(thirdState(tmp));
                    break;
                }
                case 3: {
                    result = new ArrayList<>(fourthState(tmp));
                    break;
                }
                case 4: {
                    result = new ArrayList<>(fifthState(tmp));
                    break;
                }
                case 5: {
                    result = new ArrayList<>(sixthState(tmp));
                    break;
                }
                case 6: {
                    result = new ArrayList<>(seventhState(tmp));
                    break;
                }
                case 7: {
                    result = new ArrayList<>(eighthState(tmp));
                    break;
                }
                case 8: {
                    result = new ArrayList<>(ninthState(tmp));
                    break;
                }
                case 10: {
                    System.out.println("Error");
                    break;
                }
                default: {
                    System.out.println("Error");
                    break;
                }
            }
        } else {
            //  System.out.println("Решение найдено");
        }
        return result;
    }

    static private int sum(ArrayList<Integer> state) {
        int sum = 0;
        for (int i = 0; i < state.size(); i++) {
            for (int j = 0; j < end.size(); j++) {
                if (end.get(j).equals(state.get(i))) {
                    sum = sum + Math.abs(j - i) / 3 + Math.abs(j - i) % 3;
                }
            }
        }
        //   System.out.println("sum = " + sum);
        return sum;
    }

    static private ArrayList<ArrayList<Integer>> minSumReturn(ArrayList<ArrayList<Integer>> tmp) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(tmp);
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < tmp.size(); j++) {
                if (sum(result.get(i)) > sum(result.get(j))) {
                    Collections.swap(result, i, j);
                }
            }
        }
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i) + " " + sum(result.get(i)));
//        }
        return result;

    }

    public void findResult(ArrayList<Integer> tmp) {
       //test

    }

    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Integer> al = new ArrayList<>();

        //field=[1,2,3,8,0,4,7,6,5]
        al.add(1);
        al.add(0);
        al.add(3);
        al.add(8);
        al.add(2);
        al.add(5);
        al.add(7);
        al.add(6);
        al.add(4);
        Field obj = new Field(al);
        System.out.println("Исходник " + al);
        obj.findResult(al);

    }
}
