package CategoryPractice;

import com.example.phoneb.IPhoneBook;
import com.example.phoneb.PhoneBookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatrgoryServiceImpl implements ICategoryService<ICategory>{
    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    private boolean isValidInsert(ICategory dto) {
        if (dto == null) {
            return false;
        } else if (dto.getName() == null || dto.getName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public ICategory findById(Long id) {
        Optional<CategoryEntity> find = this.categoryJpaRepository.findById(id);
        return find.orElse(null);
    }

    @Override
    public List getAllList() {
        List<ICategory> list = new ArrayList<>();
        for (CategoryEntity entity : this.categoryJpaRepository.findAll()) {
            list.add((ICategory) entity);
        }
        return list;
    }

    @Override
    public ICategory insert(ICategory category) throws Exception {
        if(!this.isValidInsert((ICategory) category)){
            return null;
        }
        CategoryEntity entity = new CategoryEntity();
        entity.copyFields(category);
        ICategory result = this.categoryJpaRepository.saveAndFlush(entity);
        return result;
    }

    @Override
    public ICategory insert(String name) throws Exception {
        CategoryDto categoryDto = CategoryDto.builder()
                .id(0L)
                .name(name).build();
        return this.insert(categoryDto);
    }

    @Override
    public boolean remove(Long id) throws Exception {
        ICategory find = this.findById(id);
        if (find == null) {
            return false;
        }
        this.categoryJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public ICategory update(Long id, ICategory category) throws Exception {
        ICategory find = this.findById(id);
        if (find == null) {
            return null;
        }
        CategoryEntity entity = CategoryEntity.builder()
                .id(id).name(find.getName())
                .build();
        entity.copyFields(category);
        return this.categoryJpaRepository.saveAndFlush(entity);
    }

    @Override
    public List getListFromName(String findName) {
        if (findName == null || findName.isEmpty()) {
            return new ArrayList<>();
        }
        List<CategoryEntity> list = this.categoryJpaRepository.findAllByNameContains(findName);
        List<IPhoneBook> result = list.stream()
                .map(item -> (IPhoneBook) item)
                .toList();
        return result;
    }
}
