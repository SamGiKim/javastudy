package CategoryPractice;

import com.example.phoneb.IPhoneBook;

import java.util.List;

public interface ICategoryService<T> {
    T findById(Long id);

    List<T> getAllList();

    ICategory insert(String name) throws Exception;

    ICategory insert(T category) throws Exception;

    boolean remove(Long id) throws Exception;

    ICategory update(Long id, T categoey) throws Exception;

    List<T> getListFromName(String findName);
}
