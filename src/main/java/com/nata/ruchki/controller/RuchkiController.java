package com.nata.ruchki.controller;

import com.nata.ruchki.data.service.CategoryService;
import com.nata.ruchki.data.service.ProductService;
import com.nata.ruchki.data.value.CategoriesValue;
import com.nata.ruchki.data.value.Model;
import com.nata.ruchki.data.value.ProductsValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@SuppressWarnings("ALL")
@RestController
public class RuchkiController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());//для отображения в консоли логов

    private CategoryService categoryService;
    private ProductService productService;

    //конструктор
    public RuchkiController(CategoryService categoryService, ProductService productService) {

        this.categoryService = categoryService;
        this.productService = productService;
    }

    //EndPoints

    //Аннотация @RequestMapping предназначена для того, чтобы задать методам адреса, по которым они будут доступны
    //параметр value предназначен для указания адреса
    // metod - метод зароса
    //consumes - то, что отдает,  определяет тип содержимого тела запроса
    //application/json - определяет, что Content-Type запроса, который отправил клиент должен быть "application/json"
    //produces - получет, определяет формат возвращаемого методом значения
    @RequestMapping(value = "/category", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Model<Long> addCategory(@RequestBody CategoriesValue categoriesValue) { //добавляет новую категорию  //Model -
        Long id = categoryService.add(categoriesValue);
        return new Model<>(id);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    public CategoriesValue updateCategory(@RequestBody CategoriesValue categoriesValue) {//обновляет категорию с внесенными изменениями
        return categoryService.update(categoriesValue);
    }

    @RequestMapping(value = "/category/list", method = RequestMethod.GET, produces = {"application/json"})
    public List<CategoriesValue> listCategory() {
        return categoryService.list();
    }//вызывает список категорий

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public CategoriesValue category(@PathVariable Long id) { //находит одну категорию по id
        return categoryService.find(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Model<Long> addProduct(@RequestBody ProductsValue productsValue) {
        Long id = productService.add(productsValue);
        return new Model<>(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    public ProductsValue updateProduct(@RequestBody ProductsValue productsValue) {
        return productService.update(productsValue);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ProductsValue products(@PathVariable Long id) {//@PathVariable указывает на то, что данный параметр получается из адресной строки(id)
        return productService.find(id);
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET, produces = {"application/json"})
    public List<ProductsValue> listProducts() {
        return productService.list();
    }

    //загрузка картинки в БД
    @RequestMapping(value = "/product/picture/{id}", method = RequestMethod.POST, consumes = {"multipart/form-data"}, produces = {"application/json"})
    public Model<String> singleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable Long id) {//@RequestParam транслирует значение параметра запроса в переменную
        //MultipartFile - класс для сохранения изображений
        //try..catch - перехват ошибок
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();//get.Bytes - метод класса MultipartFile, присваивает массиву bytes загруженные байты из file
            productService.upload(bytes, id);

            //для отображения на консоли
            logger.debug("id = {} ", id);
            logger.debug("Длина файла = {}", bytes.length);

            // если возникла ошибка выполняется catch
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Model<>("ok"); //при успешной закгрузке картинки
    }

    @RequestMapping(value = "/downloadFile/{id}", method = RequestMethod.GET)
    // HttpServletResponse - спец параметр для передачи ответа
    public StreamingResponseBody getSteamingFile(@PathVariable Long id, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg"); //указывет, что мы отдаем в ответ
        response.setHeader("Content-Disposition", "attachment; filename=\"picture.jpg\""); // указать имя файла(конр имя не обязательно)

        byte file[] = productService.download(id);
        //"магия"
        InputStream inputStream = new ByteArrayInputStream(file);
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                System.out.println("Writing some bytes..");
                outputStream.write(data, 0, nRead);
            }
        };
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public List<ProductsValue> listSearch(@RequestBody Model<String> stringSearch) {
        return productService.listSearch(stringSearch.getValue());
    }


}