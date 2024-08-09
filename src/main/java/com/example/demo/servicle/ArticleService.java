package com.example.demo.servicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ArticleRepository;
import com.exmple.demo.vo.Article;

@Service
public class ArticleService {
	
	
	@Autowired
	private ArticleRepository articleRepository;

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	// 작성
	public Article writeArticle(String title, String body) {
		return articleRepository.writeArticle(title, body);
	}
	// 수정
	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}
	// 삭제
	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}
	// 글 존재여부 확인
	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}
    // 리스트
	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}
	

}