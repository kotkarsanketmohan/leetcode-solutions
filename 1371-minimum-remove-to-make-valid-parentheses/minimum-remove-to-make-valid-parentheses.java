class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder str = new StringBuilder(s);

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(ch=='('){
                st.push(i);
            }
            else if(ch==')'){
                if(st.isEmpty())
                    str.setCharAt(i,'*');
                else
                    st.pop();
            }
        }

        while(!st.isEmpty()){
            str.setCharAt(st.pop(),'*');
        }
        
        StringBuilder ans=new StringBuilder();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='*')
                ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}