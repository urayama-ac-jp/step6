# 【第6回】フレームワークを使ったプログラミング
## テーマ
1. バリデーション機能(入力チェック機能)について

## 開発環境について
* この演習では、Codespacesと呼ばれるサービスを使って開発を行います。
* ブラウザ上で動作する開発環境です、インストール不要で使う事ができます。

## Codespacesで実行してみよう
* 第一回で実施した[手順](/Codespacesの実行手順.md)を参照してください。

## バリデーション機能(入力チェック機能)について学習
1. `Let's try!`を押します。<br>
![image](https://user-images.githubusercontent.com/32722128/154530075-1e1d9fb6-a53e-42a4-a457-3ffebf1554f6.png)

2. コメント投稿画面が表示される事を確認しましょう。<br>
![image](https://user-images.githubusercontent.com/32722128/154530176-e9485cda-7213-458e-854f-714f6044a1b0.png)

3. 以下のように値を入力し、コメント投稿ボタンを押してください。<br>
![image](https://user-images.githubusercontent.com/32722128/154540115-078a9011-214b-4190-bacb-c8a72f215622.png)

4. バリデーション機能によってエラーが表示される事を確認してください。<br>
![image](https://user-images.githubusercontent.com/32722128/154534101-d2ca1cbe-9135-4f48-98b9-6eead0302d1b.png)

5. 確認が終わったら、タブを閉じましょう<br>
![image](https://user-images.githubusercontent.com/32722128/150733257-a1056c19-1b24-412b-8bfc-a6063e75c785.png)

6. デバック実行中ですので、停止ボタンを押して、デバック実行を停止しましょう。<br>
![image](https://user-images.githubusercontent.com/32722128/150748527-d7121765-5142-4f5a-9769-33c0c23627a4.png)

## 解説
### バリデーション機能の仕組み
1. フォームクラスである、Commentクラスのフィールドに`@Size`(桁数チェック)、`@NotEmpty`(必須チェック NULL×、空文字×)、`@Email`(メールアドレスの形式チェック)とそれぞれの項目で行いたいチェック内容を次のようなアノテーションで指定しています。<br>
また、メッセージを指定されない場合は既定のメッセージが表示されます。<br>
![image](https://user-images.githubusercontent.com/32722128/154534631-1bfccb3b-2c80-4a9a-bcff-eb629303f630.png)

2. Controllerが受け取るフォームに`@Validated`アノテーションを付与する事で、メソッド内の処理が開始される前にバリデーションチェック処理を行い、結果が`BindingResult`に格納されます。<br>
![image](https://user-images.githubusercontent.com/32722128/154540321-b76d4f12-4fe4-4b4a-af93-1da3a57b0fcd.png)

3. hasError()メソッドでエラーの有無を確認します、エラーがあればtrueとなり、確認画面ではなく、元の画面を表示するようにしています。 <br>
![image](https://user-images.githubusercontent.com/32722128/154539057-127d9739-480a-4f46-b499-01eae579add7.png)

4. view(Thymeleaf)がエラー内容を受け取り画面表示しています。<br>
![image](https://user-images.githubusercontent.com/32722128/154538539-2fca7e44-8fbb-4f99-9cea-ba37cb3249f6.png)

## 演習level1 step6
1. STEP-6のページを開きます、なにも入力せずにコメント投稿ボタンを押してください。<br>
メールアドレスにも必須チェックが掛かるようにしましょう。  
エラーメッセージは「メールアドレスを入力してください」に変更してください。
![image](https://user-images.githubusercontent.com/32722128/154542682-b80d6d97-66c8-49ab-9382-35c070ae04c7.png)

## ヒント
1. Commentクラスのフィールドに必須チェック(NULL×、空文字×)のアノテーションを追加しましょう。 
* 編集先:`~/src/main/java/com/classroom/assignment/model/request/Comment.java`

## テスト
* 提出前に回答があっているかテストしてみましょう。

1. `~/src/test/java/com/classroom/assignment/controller/api/Step6ControllerTests.java`を開きます。

2. クラス名の前の再生ボタンをクリックします。(画面コピーは一度テスト実施済みのためチェックマークに変わっています。)
![image](https://user-images.githubusercontent.com/32722128/154553158-36f9ed93-68bf-4335-93da-adda5351028a.png)

3. 再生ボタンがチェックマークに変わればテスト成功です！

## 課題の提出
* 課題の提出は第一回と同じ[操作](/課題の提出手順.md)のコミット・プッシュ・プルリクエストを実施しましょう。
