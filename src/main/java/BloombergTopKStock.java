import java.util.*;

public class BloombergTopKStock {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BloombergTopKStock topKStocks = new BloombergTopKStock();
        topKStocks.addStocksVolume2("INTC", 12);
        topKStocks.addStocksVolume2("CSCO", 20);
        topKStocks.addStocksVolume2("AA", 10);
        topKStocks.addStocksVolume2("INTC", 18);
        topKStocks.addStocksVolume2("UAL", 4);
        topKStocks.addStocksVolume2("BOE", 2);
        topKStocks.addStocksVolume2("BOA", 16);
        topKStocks.addStocksVolume2("BOA", 24);

        //BOA = 40
        //INTC = 30
        //CSCO = 20
        //AA = 10
        //UAL = 4;
        //BOE = 2


        List<String> ans = topKStocks.topKStocks2(5);

        System.out.println("Top 5 stocks are as follows: " + ans.size());
        for (String stock : ans) {
            System.out.println(stock);
        }

        // BOA, INTC, CSCO, AA, UAL, BOE
    }

    HashMap<String, Integer> stockVolumeMap = new HashMap<>();
    TreeMap<Integer, Integer> sortedStock = new TreeMap<>(Collections.reverseOrder());
    TreeMap<Integer, Set<String>> sortedStockName = new TreeMap<>(Collections.reverseOrder());

    public void addStocksVolume2(String stockSymbol, int volume) {
        if (!stockVolumeMap.containsKey(stockSymbol)) {
            stockVolumeMap.put(stockSymbol, volume);

            Set<String> stockNameSet = sortedStockName.getOrDefault(volume, new HashSet<>());
            stockNameSet.add(stockSymbol);
            sortedStockName.put(volume, stockNameSet);
        } else {
            int initialStockVolume = stockVolumeMap.get(stockSymbol);
            Set<String> stockVolumeName = sortedStockName.getOrDefault(initialStockVolume, new HashSet<>());

            //remove initial stock volume count if it is 1 or reduce by -1
            stockVolumeName.remove(stockSymbol);

            int newStockVolume = initialStockVolume + volume;
            Set<String> stockNameSet = sortedStockName.getOrDefault(volume, new HashSet<>());
            stockNameSet.add(stockSymbol);
            sortedStockName.put(newStockVolume, stockNameSet);
            stockVolumeMap.put(stockSymbol, newStockVolume);
        }
    }

    public List<String> topKStocks2(int k) {
        List<String> top = new ArrayList<>(k);
        for (Map.Entry<Integer, Set<String>> entry : sortedStockName.entrySet()) {
            Set<String> nameSet = entry.getValue();

            for (String name : nameSet) {
                top.add(name);

                if (top.size() == k) break;
            }

            if (top.size() == k) break;
        }

        return top;
    }

    public void addStocksVolume(String stockSymbol, int volume) {
        if (stockVolumeMap.containsKey(stockSymbol)) {
            stockVolumeMap.put(stockSymbol, stockVolumeMap.get(stockSymbol) + volume);
            sortedStock.put(volume, sortedStock.getOrDefault(volume, 0) + 1);
        } else {
            int initialStockVolume = stockVolumeMap.getOrDefault(stockSymbol, 0);
            int stockVolumeCount = sortedStock.getOrDefault(initialStockVolume, 0);

            //remove initial stock volume count if it is 1 or reduce by -1
            if (stockVolumeCount == 1) {
                sortedStock.remove(initialStockVolume);
            } else {
                sortedStock.put(initialStockVolume, stockVolumeCount - 1);
            }

            int newStockVolume = initialStockVolume + volume;
            sortedStock.put(newStockVolume, sortedStock.getOrDefault(newStockVolume, 0) + 1);
            stockVolumeMap.put(stockSymbol, newStockVolume);
        }
    }

    public int topKStocks(int k) {
        int count = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : sortedStock.entrySet()) {
            int volume = entry.getKey();
            int times = entry.getValue();

            for (int i = 0; i < times; i++) {
                sum += volume * times;
                count++;

                if (count == k) break;
            }

            if (count == k) break;
        }

        return sum;
    }
}
