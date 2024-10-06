public class Memo {
    private String name;
    private String time;
    private String cont;

    public boolean isSameName(Memo b) {
        if(name.equals(b.getName())) return true;
        else return false;
    }

    public String getName() { // 메모 작성자 이름 리턴
        return name;
    }

    public int length() { // 메모 텍스트의 길이
        return cont.length();
    }

    public void show() { // 메모 내용 출력
        System.out.println(name + ", " + time + " " + cont);
    }

    public Memo(String name, String time, String cont) {
        this.name = name;
        this.time = time;
        this.cont = cont;
    }

    public static void main(String[] args) {
        Memo a = new Memo("유송연", "10:10", "자바 과제 있음");
        Memo b = new Memo("박채원", "10:15", "시카고로 어학 연수가요!");
        Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요.");

        a.show();
        if(a.isSameName(b)) System.out.println("동일한 사람입니다.");
        else System.out.println("다른 사람입니다.");
        System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length());
    }

}