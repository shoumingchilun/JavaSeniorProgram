package Enum;

/**
 * @auther 齿轮
 * @create 2022-04-08-9:57
 */
public enum Months {
    January(1,"Jan"),
    February(2,"Feb"),
    March(3,"Mar"),
    April(4,"Apr"),
    May(5,"May"),
    June(6,"Jun"),
    July(7,"Jul"),
    August(8,"Aug"),
    September(9,"Sept"),
    October(10,"Oct"),
    November(11,"Nov"),
    December(12,"Dec")
    ;
    public final String DESC;
    public final int month;
    Months(int m,String str){
        month = m;
        DESC = str;
    }
    public void show(){
        System.out.println(month+":"+DESC);
    }

    public static void main(String[] args) {
        January.show();
    }
}
