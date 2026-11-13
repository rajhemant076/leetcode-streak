class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String a[]=sentence1.trim().split("\\s+");
        String b[]=sentence2.trim().split("\\s+");
        int i=0;
        int j=0;
        while(i<a.length && i<b.length && a[i].equals(b[i]))i++;
        while(j<a.length-i && j<b.length-i && a[a.length-j-1].equals(b[b.length-1-j]))j++;
        if(i+j>=Math.min(a.length,b.length))return true;
        return false;
    }
}