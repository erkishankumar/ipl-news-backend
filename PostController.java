@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PostController {

 @Autowired
 PostRepository repo;

 @GetMapping
 public List<Post> get(@RequestParam(required=false) String team){

  List<Post> posts = (team!=null)?repo.findByTeam(team):repo.findAll();

  posts.forEach(p->{
   if(p.pinExpiry!=null && p.pinExpiry.isBefore(LocalDateTime.now())){
    p.isPinned=false;
   }
  });

  posts.sort((a,b)->{
   if(a.isHighlight!=b.isHighlight) return b.isHighlight?1:-1;
   if(a.isPinned!=b.isPinned) return b.isPinned?1:-1;
   return b.createdAt.compareTo(a.createdAt);
  });

  return posts;
 }

 @PostMapping
 public Post create(@RequestBody Post p){
  p.createdAt=LocalDateTime.now();
  return repo.save(p);
 }
}