package com.dsa.array;

import java.util.*;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        //System.out.println(fullJustify(words, 16));
        //System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        Integer[][] arr = {{0, 1, 10}, {2, 0, 5}};
        new TextJustification().optimalBalance(arr);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int lineLength = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            int spaces = maxWidth - lineLength;
            int gaps = j - i - 1;

            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int spaceBetween = spaces / gaps;
                int extraSpaces = spaces % gaps;
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spaceBetween + (k - i < extraSpaces ? 1 : 0); s++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            if (isOperator(c)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(eval(num1, num2, c.charAt(0)));
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String c){
        if(c=="+" || c=="-" || c=="*" || c=="/")
            return true;
        return false;
    }

    private static int eval(int num1, int num2, char c){
        switch(c){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                return num1/num2;
        }
        return 0;
    }



    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Map<String, Double>> graph = generateGraph(equations, values);
        double[] result = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            List<String> query = queries.get(i);
            result[i] = dfs(query.get(0), query.get(1), new HashSet<>(), graph);
        }
        return result;
    }

    public double dfs(String src, String dest, Set<String> visited, HashMap<String, Map<String, Double>> graph){
        if(!graph.containsKey(src))
            return -1;

        if(graph.get(src).containsKey(dest)){
            return graph.get(src).get(dest);
        }

        for(Map.Entry<String, Double> neighbour:graph.get(src).entrySet()){
            if(!visited.contains(neighbour.getKey())){
                double result = dfs(neighbour.getKey(), dest, visited, graph);
                if(result!=-1)
                    return neighbour.getValue()*result;
            }
        }
        return -1;
    }

    private HashMap<String, Map<String, Double>> generateGraph(List<List<String>> equations, double[] values){
        HashMap<String, Map<String, Double>> graph = new HashMap<>();
        for(int i=0;i<values.length;i++){
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            graph.putIfAbsent(src, new HashMap<>());
            graph.get(src).put(dest, values[i]);
            graph.putIfAbsent(dest, new HashMap<>());
            graph.get(dest).put(src, 1/values[i]);
        }
        return graph;
    }

    public void optimalBalance(Integer[][] arr){
        int maxIndex = 0;
        for (Integer[] transaction : arr) {
            maxIndex = Math.max(maxIndex, Math.max(transaction[0], transaction[1]));
        }

        int[] balance = new int[maxIndex + 1];
        Arrays.fill(balance, 0);

        for(int i=0;i<arr.length;i++){
            balance[arr[i][0]]+=arr[i][2];
            balance[arr[i][1]]-=arr[i][2];
        }

        List<Integer> positives = new ArrayList<>();
        Deque<Integer> negatives = new ArrayDeque<>();

        for (int i = 0; i < balance.length; i++) {
            if (balance[i] > 0)
                positives.add(balance[i]);
            else if (balance[i] < 0) {
                negatives.add(balance[i]);
            }
        }
        System.out.println(recursion(positives, negatives));
    }

    private int recursion(List<Integer> positives, Deque<Integer> negatives) {
        if (positives.isEmpty() && negatives.isEmpty())
            return 0;

        int minTransactions = Integer.MAX_VALUE;
        int negative = negatives.pollFirst();

        for (int i = 0; i < positives.size(); i++) {
            int positive = positives.get(i);
            if (positive + negative == 0) {
                positives.remove(i);
                minTransactions = Math.min(minTransactions, 1 + recursion(positives, negatives));
                positives.add(i, positive); // backtrack
            } else if (positive + negative > 0) {
                positives.set(i, positive + negative);
                minTransactions = Math.min(minTransactions, 1 + recursion(positives, negatives));
                positives.set(i, positive); // backtrack
            } else {
                negatives.addFirst(positive + negative);
                positives.remove(i);
                minTransactions = Math.min(minTransactions, 1 + recursion(positives, negatives));
                positives.add(i, positive); // backtrack
                negatives.pollFirst(); // backtrack
            }
        }

        negatives.addFirst(negative); // backtrack
        return minTransactions;
    }
}