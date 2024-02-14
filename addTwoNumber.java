import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class addTwoNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder p1 = new StringBuilder().append(l1.val);
        StringBuilder p2 = new StringBuilder().append(l2.val);
        while(l1.next != null) {
            l1 = l1.next;
            p1.append(l1.val);
        }
        while(l2.next != null) {
            l2 = l2.next;
            p2.append(l2.val);
        }
        BigInteger p1Int = new BigInteger(String.valueOf(p1.reverse()));
        BigInteger p2Int = new BigInteger(String.valueOf(p2.reverse()));
        BigInteger soma = p1Int.add(p2Int);
        String somaStr = soma.toString();
        ListNode resultado = new ListNode(Character.getNumericValue(somaStr.charAt(somaStr.length() - 1)));
        ListNode atual = resultado;

        for (int i = somaStr.length() - 2; i >= 0; i--) {
            atual.next = new ListNode(Character.getNumericValue(somaStr.charAt(i)));
            atual = atual.next;
        }
        return resultado;
    }
}