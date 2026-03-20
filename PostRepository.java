public interface PostRepository extends JpaRepository<Post, Long> {
 List<Post> findByTeam(String team);
}