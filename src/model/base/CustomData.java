package model.base;

public abstract class CustomData<T> {
    public CustomData(String dataName, T data) throws Exception {
        if (validData(data)){
            this.dataName = dataName;
            this.data = data;
        }
        else
            throw new Exception("Ошибка данных!");
    }

    public String getDataName() {
        return dataName;
    }

    public T getData() {
        return data;
    }

    private String dataName;
    private T data;
    public abstract boolean validData(T data);

    @Override
    public String toString() {
        return "CustomData{" +
                "dataName='" + dataName + '\'' +
                ", data=" + data +
                '}';
    }
}
