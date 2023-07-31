package Lesson_2.Sequences;

public class SequencesImpl implements SequencesGenerator {

    @Override //  2, 4, 6, 8, 10, 12, 14,
    public void a(int n) {
        int S=0;
        System.out.print("A:  ");
        for(int i=0; i<n; i++){
          S=S+2;
            System.out.print(S+", ");
        }
        System.out.println("");
    }
    @Override //3, 5, 7, 9, 11, 13, 15,
    public void b(int n) {
        int S=1;
        System.out.print("B:  ");
        for(int i=0; i<n; i++) {
            System.out.print(S + ", ");
            S = S + 2;
        }
        System.out.println("");
    }
    @Override  // 1, 4, 9, 16, 25, 36, 49,
    public void c(int n) {
        System.out.print("C:  ");
        for(int i=1; i<=n; i++)
            System.out.print(i*i+", ");
        System.out.println("");
    }
    @Override   // 1, 8, 27, 64, 125, 216, 343,
    public void d(int n) {
        System.out.print("D:  ");
        for(int i=1; i<=n; i++)
            System.out.print(i*i*i+", ");
        System.out.println("");
    }
    @Override  // 1, -1, 1, -1, 1, -1,
    public void e(int n) {
        System.out.print("E:  ");
        int S =-1;
        for(int i=1; i<=n; i++) {
            S = S * (-1);
            System.out.print(S + ", ");
        }
        System.out.println("");
    }
    @Override   // 1, -2, 3, -4, 5, -6, 7,
    public void f(int n) {
        int Znak =1;
        int Si =1;
        System.out.print("F:  ");
        for(int i=1; i<=n; i++){
            System.out.print(Si*Znak+", ");
            Si= Si+1;
            Znak=Znak*(-1);
        }
        System.out.println("");
    }
    @Override  // 1, -4, 9, -16, 25, -36, 49,
    public void g(int n) {
        int Znak =1;
        int Si =1;
        System.out.print("G:  ");
        for(int i=1; i<=n; i++){
            System.out.print(Si*Si*Znak+", ");
            Si++ ;
            Znak=Znak*(-1);
        }
        System.out.println("");
    }
    @Override  // 1, 0, 2, 0, 3, 0, 4,
    public void h(int n) {

        int Si =1;
        int j=1;
        int Sout;
        System.out.print("H:  ");
        for(int i=0; i<n; i++){
            if (j==1) {
                Sout= Si;
                Si++;
                j=0;
            }
             else {
                j=1; Sout =0;
            }
            System.out.print(Sout+", ");
        }
        System.out.println("");
    }
    @Override // 1, 2, 6, 24, 120, 720, 5040,
    public void i(int n) {

        int Si =1;
        System.out.print("I:  ");
        for(int i=1; i<=n; i++){
            Si= Si*i;
            System.out.print(Si+", ");
        }
        System.out.println("");
    }
    @Override  // 1, 1, 2, 3, 5, 8, 13,
    public void j(int n) {
        int Si_1 =1;
        int Si_2 =1;
        int Sn=1;
        System.out.print("J:  ");
        for(int i=1; i<=n; i++){
            if ((i==1)|(i==2)) Sn=1;
            if (i>2) {
                Sn= Si_1+Si_2;
                Si_2= Si_1; Si_1= Sn;
            }
            System.out.print(Sn+", ");

        }
        System.out.println("");
    }

}
