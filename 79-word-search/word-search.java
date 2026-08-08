class Solution {
    public boolean exist(char[][] board, String word) {
         for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {

                if (helper(board, 0, word, r, c)) {
                    return true;
                }
            }
        }

        return false;

        
    }
    public boolean helper(char[][] board,int index,String word,int r,int c){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length ){
            return false;
        }
        if(board[r][c]!=word.charAt(index))return false;
        if(index==word.length()-1)return true;
        char ch=board[r][c];
        board[r][c]='#';
        boolean found=helper(board,index+1,word,r+1,c) || helper(board,index+1,word,r,c+1) || helper(board,index+1,word,r-1,c) || helper(board,index+1,word,r,c-1);
        board[r][c]=ch;

        return found;
    }
}