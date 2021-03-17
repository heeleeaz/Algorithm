import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//https://leetcode.com/problems/invalid-transactions/
class BloombergInvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        HashMap<String, List<Transaction>> transactionMap = new HashMap<>();
        List<String> invalidTransactions = new ArrayList<>();


        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            List<Transaction> list = transactionMap.getOrDefault(t.name, new ArrayList<>());
            list.add(t);
            transactionMap.put(t.name, list);
        }


        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            if (!isValid(transactionMap.get(t.name), t)) {
                invalidTransactions.add(transaction);
            }
        }

        return invalidTransactions;
    }

    private boolean isValid(List<Transaction> transactions, Transaction transaction) {
        if (transactions.size() <= 1 && transaction.amount < 1000) return true;

        for (Transaction t : transactions) {
            if (transaction.isInValid(t.city, t.time)) return false;
        }

        return true;
    }

    static class Transaction {
        String name;
        int time;
        int amount;
        String city;

        Transaction(String transaction) {
            String[] arr = transaction.split(",");
            this.name = arr[0];
            this.time = Integer.parseInt(arr[1]);
            this.amount = Integer.parseInt(arr[2]);
            this.city = arr[3];
        }

        public boolean isInValid(String city, int time) {
            if (this.amount > 1000) return true;
            return !this.city.equals(city) && Math.abs(this.time - time) <= 60;
        }
    }
}