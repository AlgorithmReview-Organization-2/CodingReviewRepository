# https://leetcode.com/problems/design-twitter/

'''
1. 아이디어 :
    getNewsFeed에서 본인 또는 팔로잉하는 userID에 해당되면 ans에 추가한다.
2. 시간복잡도 :
    O(1), O(n), O(1), O(1)
3. 자료구조 :
    딕셔너리, 큐
'''


class Twitter:

    def __init__(self):
        self.follows = defaultdict(set)
        self.tweets = deque()

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets.appendleft((userId, tweetId))

    def getNewsFeed(self, userId: int) -> List[int]:
        ans = []
        for user, tweet in self.tweets:
            if len(ans) >= 10:
                break
            if user == userId or user in self.follows[userId]:
                ans.append(tweet)
        return ans

    def follow(self, followerId: int, followeeId: int) -> None:
        self.follows[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.follows[followerId]:
            self.follows[followerId].remove(followeeId)

# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
