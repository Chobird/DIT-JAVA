abstract class PairMap {
    protected String[] keyArray;
    protected String[] valueArray;

    public PairMap(int size) {
        keyArray = new String[size];
        valueArray = new String[size];
    }

    abstract public String get(String key);
    abstract public void put(String key, String value);
    abstract public String delete(String key);
    abstract public int length();
}

class Dictionary extends PairMap {
    private int size;

    public Dictionary(int size) {
        super(size);
        this.size = size;
    }

    @Override
    public String get(String key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public void put(String key, String value) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value; // 이미 존재하는 키는 값을 업데이트
                return;
            }
        }
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == null) {
                keyArray[i] = key;
                valueArray[i] = value;
                return;
            }
        }
    }

    @Override
    public String delete(String key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                String oldValue = valueArray[i];
                keyArray[i] = null;
                valueArray[i] = null;
                return oldValue;
            }
        }
        return null;
    }

    @Override
    public int length() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (keyArray[i] != null) {
                count++;
            }
        }
        return count;
    }
}

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++");

        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));

        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}
