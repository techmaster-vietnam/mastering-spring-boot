# Giới thiệu

Xin chào, mình là Dũng, giám đốc điều hành của TechMaster, là tác giả của hai cuốn sách, Làm chủ các mẫu thiết kế trong lập trình và Những nguyên tắc sống còn trong lập trình, là đồng tác giả của cuốn AI cho người mới bắt đầu sắp ra mắt trong năm 2024. Ngoài ra mình cũng là nhà sáng lập tổ chức mã nguồn mở Young Monkeys Việt Nam. Công việc của mình tập trung vào việc chia sẻ kiến thức để mang lại giá trị cho cộng đồng vì một Việt Nam phát triển. Ngoài ra mình cũng muốn thu hút các giảng viên đến giảng dạy tại Techmaster và các bạn học viên đăng ký tham gia các khoá học của Techmaster. Không dài dòng thêm nữa, mình sẽ đến phần mở đầu cho loạt bài về mastering spring boot.

![Tạ Văn DŨng](https://media.techmaster.vn/api/static/c2m5ou451cob24f6skeg/99tgcQhH)

# Lời mở đầu

Java từ xưa đến nay vẫn là một ngôn ngữ phổ biến, đặc biệt là trong lĩnh vực lập trình hệ thống, và khi đã nhắc đến Java thì không thể không nhắc đến Spring, một framework khổng lồ với rất nhiều các thư viện khác nhau ở bên trong nó.
Không có con số thống kê cụ thể mức độ phổ biến của Spring, nhưng tất cả các công ty mình đã trải qua, đã gặp gỡ tiếp xúc, và ở tập đoàn mới đây mình vừa rời đi thì Spring vẫn là lựa chọn hàng đầu nếu không muốn nói là duy nhất để phát triển hệ thống. Ngoài Spring thì cũng có có các framework khác như JakartaEE được duy trì bởi cộng đồng, Vertx của Eclipse, EzyFox của Young Monkeys, tuy nhiên Spring theo quan điểm cá nhân của mình vẫn đang chiếm 80% về mức độ phổ biến.
Chính vì những yếu tố kể trên và với khẩu hiệu của TechMaster "Học là có việc" nên mình đã quyết định viết loạt bài về masting Spring boot để giúp các bạn làm chủ được Sping nói chung và Spring boot nói riêng, để các bạn có thể tìm được một công việc mà mình mơ ước.

# Giới thiệu một chút Spring

![Spring-Boot](https://media.techmaster.vn/api/static/c2m5ou451cob24f6skeg/vvdfYH3F)

Sự ra đời và phát triển của Spring cũng là một câu chuyện truyền cảm hứng cho những người lập trình viên mơ ước khởi nghiệp.
Spring được khởi xướng từ tháng 1 năm 2002, cho đến giờ cũng đã được 22 năm bởi một lập trình viên người Úc có tên Roderick "Rod" Johnson. Và bây giờ thì Spring đã được bán cho VMware thông qua việc mua lại công ty cũng có tên là Spring vào tháng 8 năm 2009 với giá 420 triệu USD. Như mình đã nói đây là một câu chuyện truyền cảm hứng khi từ một lập trình viên và một framework lại có thể tạo dựng được doanh nghiệp và bán với giá rất ấn tượng. Vậy nên bạn cũng đừng ngần ngại để khi đã hiểu rõ Spring có thể ra các framework khác và khởi nghiệp trên nó nhé.

# Lộ trình cho loạt bài

Mình chưa thể ước lượng được chính xác số lượng bài viết cho loạt bài này, mình nghĩ có thể tầm vài chục đến hơn 100 bài viết được chia thành các nhóm chính như sau:
1. Tìm hiểu về Spring core: Trong phần này chúng ta sẽ đi tìm hiểu về các module của spring, tìm hiểu về các thành phần cơ bản của spring như annotation, các properties và các lớp cơ sở.
2. Tìm hiểu Spring boot: Trong phần này chúng ta sẽ đi tìm hiểu sâu về Spring boot để giải thích nó là gì, cách nó liên kết các thành phần lại với nhau.
3. Ứng dụng Spring boot vào xây dựng các hệ thống microservice: Trong phần này chúng ta sẽ cùng nhau ứng dụng các module như spring-data, spring-kafka, spring-message để tạo ra các hệ thống microservice cho các loại hình dự án khác nhau.
4. Triển khai một hệ thống sử dụng Spring boot: Trong phần này chúng ta sẽ cùng nhau triển khai Spring boot thông qua môi trường máy chủ có và không có docker.
5. Tự xây dựng một framework giống Spring boot từ đầu: Phần này sẽ cực kỳ thú vị khi chính chúng ta sẽ tạo ra một framework giôgns Spring boot. Mình sẽ chỉ cho các bạn rằng nó không hề khó một chút nào.

# Các tài liệu tham khảo

1. Thông tin về Spring framework: https://en.wikipedia.org/wiki/Spring_Framework
2. Thông tin về việc mua lại công ty Spring: https://en.wikipedia.org/wiki/Spring_(company)

---

Cám ơn bạn đã quan tâm đến bài viết Giới thiệu về loạt bài mastering spring boot. Để nhận được thêm các kiến thức bổ ích bạn có thể:
1. Đọc các bài viết của TechMaster trên facebook: https://www.facebook.com/techmastervn
2. Xem các video của TechMaster qua Youtube: https://www.youtube.com/@TechMasterVietnam
3. Chat với techmaster qua Discord: https://discord.gg/yQjRTFXb7a
