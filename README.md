# Öğrenci ve Ders Yönetim Sistemi

Bu proje, bir **Öğrenci ve Ders Yönetim Sistemi** uygulamasıdır. Öğrencilerin ders ekleme, silme, listeleme işlemleri yapılabilir ve ayrıca en fazla dersi alan öğrenciler görüntülenebilir. Uygulama, **Swing** kütüphanesi kullanarak grafiksel kullanıcı arayüzü (GUI) ile geliştirilmiştir. Ayrıca, öğrencilerin derslerini yönetmek için **tek yönlü bağlı liste** (singly linked list) veri yapısı kullanılmaktadır.

## Özellikler

- **Öğrenci Ekleme:** Kullanıcı yeni bir öğrenci ekleyebilir.
- **Öğrenci Silme:** Var olan bir öğrenci silinebilir.
- **Ders Ekleme:** Öğrencilere dersler eklenebilir.
- **Ders Silme:** Öğrencilerden dersler silinebilir.
- **En Fazla Dersi Alan Öğrenci:** En fazla dersi alan öğrenci görüntülenebilir.
- **Ders Listeleme:** Öğrencinin aldığı dersler listelenebilir.

## Kullanım

1. **Öğrenci Ekleme:**
   - Öğrenci adı girilerek, "Öğrenci Ekle" butonuna tıklanarak yeni bir öğrenci eklenir.
   
2. **Öğrenci Silme:**
   - Silinmek istenen öğrencinin adı girilerek, "Öğrenci Sil" butonuna tıklanarak öğrenci silinir.
   
3. **Ders Ekleme:**
   - Öğrenci adı ve ders adı girilerek, "Ders Ekle" butonuna tıklanarak bir öğrenciye ders eklenir.
   
4. **Ders Silme:**
   - Öğrenci adı ve ders adı girilerek, "Ders Sil" butonuna tıklanarak bir öğrenciden ders silinir.
   
5. **En Fazla Dersi Alan Öğrenci:**
   - "En Fazla Dersi Alan Öğrenci" butonuna tıklanarak, en fazla dersi olan öğrenci görüntülenir.
   
6. **Ders Listeleme:**
   - Öğrenci adı girilerek, "Dersleri Listele" butonuna tıklanarak, o öğrencinin aldığı dersler listelenir.

## Gereksinimler

- Java 8 veya daha yüksek bir sürüm.
- Swing GUI kütüphanesi.

## Kullanılan Veri Yapıları

- **Öğrenciler:** Her öğrenci, bağlı listede tutulur. Öğrencilerin dersleri de kendi içlerinde tek yönlü bağlı liste yapısında tutulur.
  
## Kurulum

1. Bu projeyi GitHub üzerinden veya zip dosyası olarak bilgisayarınıza indirin.
2. Java geliştirme ortamınızı (IDE) açın ve projeyi içe aktarın.
3. Uygulamayı çalıştırın ve arayüz üzerinden işlemlerinizi gerçekleştirin.

## Uygulama Arayüzü

![Öğrenci ve Ders Yönetim Sistemi Arayüzü](https://github.com/firatdemir47/Student-Course-Management-System/raw/main/Arayüz.png)


## Katkı

Katkı sağlamak isterseniz, lütfen aşağıdaki adımları izleyin:

1. Bu repository'i fork'layın.
2. Yeni bir branch oluşturun (feature/branch-name).
3. Değişikliklerinizi yapın ve commit edin.
4. Pull request açın.

## Lisans

Bu proje, [MIT Lisansı](https://opensource.org/licenses/MIT) ile lisanslanmıştır.
