
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.length() < num2.length())
            return multiply(num2, num1);

        Queue<StringBuilder> queue = new ArrayDeque<>();
        // Poprawka 1: Iterujemy od prawej do lewej (od jedności w górę)
        for (int i = num2.length() - 1; i >= 0; i--) {
            queue.add(multiply(num1, num2.charAt(i)));
        }
        return addWithOffset(queue);
    }

    private StringBuilder multiply(String s, char c) {
        int multiplier = c - '0';
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int by = s.charAt(i) - '0';
            int res = carry + by * multiplier;
            carry = res / 10;
            res = res % 10;
            sb.append(res);
        }
        sb.reverse();
        if (carry > 0)
            sb.insert(0, carry);
        return sb;
    }

    private String addWithOffset(Queue<StringBuilder> queue) {
        int offset = 1;
        var base = queue.poll();
        while (!queue.isEmpty()) {
            base = addWithOffset(base, queue.poll(), offset);
            offset++;
        }
        return base.toString();
    }

    private StringBuilder addWithOffset(StringBuilder sb1, StringBuilder sb2, int offset) {
        StringBuilder result = new StringBuilder();
        int i = sb1.length() - 1;
        int j = sb2.length() - 1;
        int carry = 0;
        int k = 0; // Licznik kroków uwzględniający offset dla sb2

        // Poprawka 2: Prawidłowe dodawanie z uwzględnieniem przesunięcia (offsetu) drugiego argumentu
        while (i >= 0 || j >= 0 || k < offset || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += sb1.charAt(i) - '0';
                i--;
            }
            // Dopóki nie przekroczymy offsetu, sb2 kontrybuuje '0' (przesunięcie w lewo / dopisanie zera)
            if (k >= offset && j >= 0) {
                sum += sb2.charAt(j) - '0';
                j--;
            }
            k++;
            carry = sum / 10;
            sum = sum % 10;
            result.append(sum);
        }
        return result.reverse();
    }
}