package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<Integer, String> sInitial = new HashMap<>(), sEnd = new HashMap<>();
        Map<String, List<Integer>> initial = new HashMap<>(), end = new HashMap<>();
        TreeSet<String> res = new TreeSet<>();
        for (int i = 0; i < phrases.length; i++) {
            String phrase = phrases[i];
            String[] sArr = phrase.split(" ");
            if (sArr.length == 0)
                continue;
            sInitial.put(i, sArr[0]);
            sEnd.put(i, sArr[sArr.length - 1]);
            initial.putIfAbsent(sArr[0], new ArrayList<>());
            initial.get(sArr[0]).add(i);
            end.putIfAbsent(sArr[sArr.length - 1], new ArrayList<>());
            end.get(sArr[sArr.length - 1]).add(i);
        }

        for (int i = 0; i < phrases.length; i++) {
            if (!sInitial.containsKey(i))
                continue;
            String init = sInitial.get(i), ed = sEnd.get(i);
            if (initial.containsKey(ed)) {
                for (Integer index : initial.get(ed)) {
                    if (index == i)
                        continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(phrases[i]);
                    if (ed.length() < phrases[index].length()) {
                        sb.append(" ");
                        sb.append(phrases[index].substring(ed.length() + 1));
                    }
                    res.add(sb.toString());
                }
            }
        }
        return new ArrayList<>(res);
    }
}