import dataaccess.FetchData;
import seedData.InitializeData;

public class Main {
    public static void main(String[] args) {
        InitializeData initializeData = new InitializeData();
        initializeData.loadData();

        FetchData fetchData = new FetchData();
        fetchData.getAllBookByNameQuery();
        fetchData.getAllBookByNativeQuery();
        fetchData.getAllBookByCriteriaQuery();
    }
}
