from locust import HttpUser, task, between
import random

class AddPost(HttpUser):
    wait_time = between(1, 2)

    def on_start(self):
        self.client.post("/api/users/login",
            json={"userId": "test1", "password": "pass1"})
        
    @task
    def view_search(self):
        sortStatus = random.choice(["CATEGORIES", "NEWEST", "OLDEST", "HIGHPRICE", "LOWPRICE", "GRADE"])
        categoryId = random.randint(1, 10)
        title = '테스트 게시글'.join(str(random.randint(1, 10000)))
        headers = {'Content-Type': 'application/json'}
        data = {"sortStatus": sortStatus,
                "categoryId": categoryId,
                "title": title}
        # print(data)
        self.client.post("/api/search", json=data, headers=headers)