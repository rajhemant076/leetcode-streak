class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        return helper("",digits,map);
    }
    public List<String> helper(String p,String up,HashMap<Integer,String> map){
        if(up.isEmpty()){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        int dig=up.charAt(0)-'0';
        String s=map.get(dig);
        List<String> ans=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            ans.addAll(helper(p+ch,up.substring(1),map));
        }
        return ans;
    }
}