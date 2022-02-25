package Arrays;

public class powerfunction {
    public int pow(int A, int B, int C) {
        if (A == 0)
            return 0;

        long res = 1, t = A;
        t = t % C;

        while (B > 0) {
            if ((B & 1) != 0) {
                res = (res * t) % C;
                B--;
            }

            t = (t * t) % C;
            B >>= 1;
        }

        return res >= 0 ? (int) res : (int) (C + res);
    }

}
