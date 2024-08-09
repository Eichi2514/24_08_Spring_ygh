package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exmple.demo.vo.Article;

@Controller
public class UsrArticleController {
	int lastArticleId;
	List<Article> articles;

	public UsrArticleController() {
		lastArticleId = 0;
		articles = new ArrayList<>();

		makeTestData();

	}

	private void makeTestData() {
		for (int i = 1; i <= 10; i++) {
			doAdd("title" + i, "body" + i);
		}
	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		int id = ++lastArticleId;
		Article article = new Article(id, title, body);
		articles.add(article);
		return article;
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getId() == id) {
				articles.remove(i);
				return id + "번 글이 삭제되었습니다";
			}
		}
		return id + "번 글이 존재하지 않습니다";
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public Object doModify(int id, String title, String body) {
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getId() == id) {
				Article article = new Article(id, title, body);
				articles.set(i, article);
				return article;
			}
		}
		return id + "번 글이 존재하지 않습니다";
	}
}