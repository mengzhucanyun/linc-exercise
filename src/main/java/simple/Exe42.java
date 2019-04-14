package simple;

/**
 * Created by linc on 2018/11/14.
 */
public class Exe42 {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int max = 0;
        int bar = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                maxIndex = i;
            }
            bar = bar + height[i];
        }
        int white = 0;
        int current = 0;
        int currentIndex = 0;
        for (int i = 0; i <= maxIndex; i++) {
            if (height[i] > current) {
                white = (i - currentIndex) * (max - current) + white;
                currentIndex = i;
                current = height[i];
            }
        }
        currentIndex = height.length - 1;
        current = height[currentIndex];
        for (int i = height.length - 1; i >= maxIndex; i--) {
            if (height[i] > current) {
                white = (currentIndex - i) * (max - current) + white;
                currentIndex = i;
                current = height[i];
            }
        }
        int res = height.length * max - white - bar;

        return res;

    }


}
