@Entity
public class Post {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 public Long id;

 public String title;
 public String content;

 public String imageUrl;
 public String videoUrl;

 public String team;

 public boolean isHighlight;
 public boolean isPinned;

 public LocalDateTime pinExpiry;
 public LocalDateTime createdAt = LocalDateTime.now();
}