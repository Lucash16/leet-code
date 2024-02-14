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
        ListNode l1 = new ListNode(9, new ListNode(4, new ListNode(9)));
        ListNode l2 = new ListNode(9, new ListNode(6, new ListNode(4)));
        addTwoNumbersGPT(l1, l2);
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

/*
    Matemática básica foi crucial neste código
    Podemos ver na linha do int soma e carry, ele faz a soma basica dos numeros por cada casa decimal.
    Quando a soma dos elementos passa de 9 ele guarda  somente a ultima casa decimal, que é o que importa
    para se gravar no ListCode, e a primeira casa decimal ele guarda no carry, sendo que esse valor guardado no carry
    vai somando com os proximos elementos, que a soma vire menor que 10 caso contrário ele será o ultimo elemente do ListNode

 */

    public static ListNode addTwoNumbersGPT(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode atual = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int soma = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = soma / 10;

            atual.next = new ListNode(soma % 10);
            atual = atual.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}