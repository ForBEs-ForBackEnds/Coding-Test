package implementation.백준_2828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int result = 0;
        int r = m;
        int l = 1;

        for (int i = 0; i < j; i++) {
            r = l + m - 1;
            int temp = Integer.parseInt(br.readLine());
            if (temp >= l && temp <= r) {
                continue;
            } else {
                if (temp < l) {
                    result += l - temp;
                    l = temp;
                } else {
                    result += temp - r;
                    l += temp - r;
                }
            }
        }

        System.out.println(result);
    }
}
