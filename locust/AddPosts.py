from locust import HttpUser, task, between
import random

class AddPost(HttpUser):
    wait_time = between(1, 2)

    def on_start(self):
        self.client.post("/api/users/login",
            json={"userId": "test1", "password": "pass1"})
        
    @task
    def add_post(self):
        self.client.post("/api/posts", json= {
            "title": f"테스트 게시글 {random.randint(1, 100000)}",
            "contents": f"테스트 컨텐츠 {random.randint(1, 100000)}",
            "categoryId": random.randint(1, 10)
        })