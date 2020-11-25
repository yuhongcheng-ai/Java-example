package custom.Demo3;
/*
 *动态规划 最长公共子序列
 */
public class DynamicProgramming {
    private  int table[][] ;
    public static void show(int table[][]){
        for (int i=0;i<table[0].length;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<table.length;j++){
                sb.append(table[j][i]);
                sb.append(",");
            }
            System.out.println(sb);
        }
    }

    public void programming(int table[][],String s1,String s2){
        char sc1[] = s1.toCharArray();
        char sc2[] = s2.toCharArray();
        for (int i=0;i<sc1.length;i++){
            for (int j=0;j<sc2.length;j++){
                if(sc1[i] == sc2[j]){
                    table[i+1][j+1] = table[i][j]+1;
                }else{
                    table[i+1][j+1] = max(table[i][j+1],table[i+1][j]);
                }
            }
        }
    }

    public int max(int x,int y){
        return x>y?x:y;
    }
    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        String s1 = "helloworld";
        String s2 = "loop";
        dp.table = new int[s1.length()+1][s2.length()+1];
        dp.programming(dp.table,s1,s2);
        show(dp.table);
    }
}
