public class test {


    public static void main(String[] args) {
        int a = 1115;
        System.out.println(readMe(-9999));
        System.out.println(readMe(9));
        System.out.println(readMe(106));
        System.out.println(readMe(1101));

    }

    public static String vietHoa(int a) {
        switch (a) {
            case 0:
                return "khong";
            case 1:
                return "mot";
            case 2:
                return "hai";
            case 3:
                return "ba";
            case 4:
                return "bon";
            case 5:
                return "nam";
            case 6:
                return "sau";
            case 7:
                return "bay";
            case 8:
                return "tam";
            case 9:
                return "chin";
            case 1000:
                return "ngan";
            case 100:
                return "tram";
            case 10:
                return "muoi";

        }
        return "";
    }

    public static String readMe(int a) {
        int tram;
        int chuc;
        int donvi;
        String outPut = "";
        if (a < 0) {
            outPut = outPut + "am ";
            a = a * -1;
        }
        if (a <= 10) {
            outPut = outPut+" "+vietHoa(a);
        } else {
            //Ngan
            if (a / 1000 > 0) {
                tram = a % 1000;
                outPut = outPut + vietHoa(a / 1000) + " ";
                outPut = outPut + vietHoa(1000) + " ";
            }
//tram

            if ((a % 1000) / 100 > 0) {
                outPut = outPut + vietHoa((a % 1000) / 100) + " ";
                outPut = outPut + vietHoa(100) + " ";
            }


//chuc
            if ((a % 100) / 10 > 0) {
                if ((a % 100) / 10 > 1) {
                    outPut = outPut + vietHoa((a % 100) / 10) + " ";
                }

                outPut = outPut + vietHoa(10) + " ";
            }
            //don vi
            if (a % 10 > 0) {
                chuc = (a % 100) / 10;
                donvi = a % 10;
                if (chuc == 0 && donvi > 0) {
                    outPut = outPut + " le " + vietHoa((a % 10)) + " ";

                } else if (chuc > 0 && donvi == 5) {
                    outPut = outPut + " lam";
                } else {
                    outPut = outPut + vietHoa((a % 10)) + " ";
                }
            }
        }
        return outPut;

    }
}
