package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 18:53
 */
@Mapper
public interface ArticleMapper {
    /**
     * create by: huining
     * description:查询所有文章
     * create time: 21:39 2020/5/5
     
     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    List<Article> listAllNotWithContent();
    /**
     * 获得最新文章
     *
     * @param limit 查询数量
     * @return 列表
     */
    List<Article> listArticleByLimit(@Param("limit")Integer limit);

    /**
     * 获取文章总数
     *
     * @param status
     * @return
     */
    Integer countArticle(@Param("status") Integer status);

    /**
     * 获取评论总数
     *
     * @return
     */
    Integer countArticleComment();

    /**
     * 获得浏览量总数
     *
     * @return 数量
     */
    Integer countArticleView();

    /**
     * 获取最后更新的文章
     *
     * @return Article
     */
    Article getLastupdateArticle();

    /**
     * create by: huining
     * description:查询相关文章
     * create time: 11:45 2020/5/3
     * @param articleId:
     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    List<Article> listAboutArticle(@Param("articleId") Integer articleId);

    /**
     * create by: huining
     * description:猜你喜欢
     * create time: 11:43 2020/5/3

     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    List<Article> listArticleByViewCount();

    /**
     * create by: huining
     * description:获取上一篇文章
     * create time: 17:11 2020/5/5
     * @param articleId:
     * @return: com.huining.ssm.blog.entity.Article
     */
    Article getAfterArticle(@Param("articleId")Integer articleId);

    /**
     * create by: huining
     * description:获取下一篇文章
     * create time: 17:11 2020/5/5
     * @param articleId:
     * @return: com.huining.ssm.blog.entity.Article
     */
    Article getPreArticle(@Param("articleId")Integer articleId);

    /**
     * create by: huining
     * description:获取随机文章
     * create time: 17:09 2020/5/5
     * @param articleId:
     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    List<Article> listRandomArticle(@Param("articleId")Integer articleId);
    List<Article> listRandomArticle2();

    /**
     * create by: huining
     * description:获得热评文章
     * create time: 17:09 2020/5/5
     * @param articleId:
     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    List<Article> listMostArticle(@Param("articleId")Integer articleId);
    List<Article> listMostArticle2();

    /**
     * create by: huining
     * description:点赞数增加
     * create time: 17:03 2020/5/3
     * @param id:
     * @return: java.lang.Integer
     */
    void increaseLikeCount(@Param("id")Integer id);

    /**
     * create by: huining
     * description:浏览数增加
     * create time: 17:05 2020/5/3
     * @param id:
     * @return: java.lang.Integer
     */
    void increaseViewCount(@Param("id")Integer id);

    /**
     * create by: huining
     * description:根据条件查询Article详情
     * create time: 17:07 2020/5/5
     * @param param:
     * @return: com.huining.ssm.blog.entity.Article
     */
    Article findArticle(Article param);

    /**
     * create by: huining
     * description:条件查询文章
     * create time: 17:07 2020/5/5
     * @param criteria:
     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    List<Article> queryArticle(HashMap<String, Object> criteria);

    /**
     * create by: huining
     * description:更新文章评论总数
     * create time: 17:10 2020/5/5
     * @param articleId:
     * @return: void
     */
    void updateCommentCount(@Param("articleId") Integer articleId);

    /**
     * create by: huining
     * description:添加文章
     * create time: 23:11 2020/5/5
     * @param article: 
     * @return: void
     */
    void insertArticle(Article article);

    /**
     * create by: huining
     * description:批量删除文章
     * create time: 23:23 2020/5/5
     * @param ids:
     * @return: void
     */
    void deleteBatch(@Param("ids")List<Integer> ids);

    /**
     * create by: huining
     * description:根据id删除文章
     * create time: 23:27 2020/5/5
     * @param id: 
     * @return: void
     */
    void deleteById(@Param("id") Integer id);

    /**
     * create by: huining
     * description:更细文章详情
     * create time: 23:51 2020/5/5
     * @param article:
     * @return: void
     */
    void updateArticle(Article article);

    /**
     * create by: huining
     * description:统计用户发表的文章数
     * create time: 17:19 2020/5/6
     * @param userId: 
     * @return: java.lang.Integer
     */
    Integer countArticleByUserId(@Param("userId") Integer userId);
}
