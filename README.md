# Java Collections: ArrayList и HashMap

## ArrayList

### Обзор

`ArrayList` — это структура данных в языке Java, предназначенная для хранения множества значений. Это усовершенствованный массив, в котором можно изменять количество элементов и с легкостью выполнять с ними различные операции.

### Использование

Для использования `ArrayList` необходимо импортировать пакет `collections.ArrayList.ArrayList`:

```java
import collections.ArrayList.ArrayList;
```

### Создание

```java
// Конструктор без параметров
ArrayList<Type> listName = new ArrayList<>();

// Конструктор с параметром int initialCapacity
ArrayList<Type> listName = new ArrayList<>(initialCapacity);

// Конструктор с параметром ArrayList
ArrayList<Type> anotherList = new ArrayList<>(existingList);
```

### Основные методы

1. **Добавление элементов**

    - `add(E element)`: Добавляет указанный элемент в конец списка.

      ```java
      listName.add(element);
      ```

2. **Доступ к элементам**

    - `get(int index)`: Возвращает элемент по указанной позиции в списке.

      ```java
      Type element = listName.get(index);
      ```

   - `indexOf(E elem)`: Возвращает индекс первого вхождения элемента в списке.

     ```java
     Type element = listName.indexOf(element);
     ```

3. **Удаление элементов**

    - `remove(int index)`: Удаляет элемент на указанной позиции в списке.

      ```java
      listName.remove(index);
      ```

    - `remove(Object obj)`: Удаляет первое вхождение указанного элемента из списка.

      ```java
      listName.remove(element);
      ```

4. **Размер и проверка на пустоту**

    - `size()`: Возвращает количество элементов в списке.

      ```java
      int size = listName.size();
      ```

    - `isEmpty()`: Возвращает `true`, если список не содержит элементов.

      ```java
      boolean isEmpty = listName.isEmpty();
      ```

5. **Установка элементов**

    - `set(int index, E element)`: Заменяет элемент на указанной позиции новым элементом.

      ```java
      listName.set(index, newElement);
      ```

6. **Преобразование в массив**

    - `toArray()`: Возвращает массив, содержащий все элементы списка в правильной последовательности.

      ```java
      Object[] array = listName.toArray();
      ```

## HashMap

### Обзор

`HashMap` — структура данных, которая хранит элементы в формате «ключ — значение». Ключ — это уникальный номер элемента, а значение — содержимое элемента.

### Использование

Для использования `HashMap` необходимо импортировать пакет `collections.HashMap.HashMap`:

```java
import collections.HashMap.HashMap;
```

### Создание

```java
// Конструктор без параметров
HashMap<KeyType, ValueType> mapName = new HashMap<>();

// Конструктор с параметром int initialCapacity
HashMap<KeyType, ValueType> mapName = new HashMap<>(initialCapacity);

// Конструктор с параметрами int initialCapacity и float loadFactor
HashMap<KeyType, ValueType> mapName = new HashMap<>(initialCapacity, loadFactor);
```

### Основные методы

1. **Помещение и обновление записей**

    - `put(KeyType key, ValueType value)`: Связывает указанное значение с указанным ключом в хеш-таблице.

      ```java
      mapName.put(key, value);
      ```

2. **Доступ к значениям**

    - `get(KeyType key)`: Возвращает значение, которое соответствует указанному ключу.

      ```java
      ValueType value = mapName.get(key);
      ```

3. **Удаление записей**

    - `remove(KeyType key)`: Удаляет элемент для указанного ключа из хеш-таблицы.

      ```java
      mapName.remove(key);
      ```

4. **Проверка наличия**

    - `containsKey(KeyType key)`: Возвращает `true`, если хеш-таблица содержит указанный ключ.

      ```java
      boolean containsKey = mapName.containsKey(key);
      ```

    - `containsValue(ValueType value)`: Возвращает `true`, если хеш-таблица содержит один или несколько элементов для указанного значения.

      ```java
      boolean containsValue = mapName.containsValue(value);
      ```

5. **Размер и проверка на пустоту**

    - `size()`: Возвращает количество элементов в хеш-таблице.

      ```java
      int size = mapName.size();
      ```

    - `isEmpty()`: Возвращает `true`, если хеш-таблица не содержит элементов.

      ```java
      boolean isEmpty = mapName.isEmpty();
      ```

6. **Получение множества ключей и коллекции значений**

    - `keySet()`: Возвращает множество ключей хеш-таблицы.

      ```java
      Set<KeyType> keys = mapName.keySet();
      ```

    - `values()`: Возвращает коллекцию значений хеш-таблицы.

      ```java
      Collection<ValueType> values = mapName.values();
      ```

7. **Очистка отображения**

    - `clear()`: Удаляет все элементы из хеш-таблицы.

      ```java
      mapName.clear();
      ```