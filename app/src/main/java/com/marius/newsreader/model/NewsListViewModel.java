package com.marius.newsreader.model;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {
    @NonNull
    public ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        newsList.add(new ArticleItemViewModel(
                "https://images.barrons.com/im-347252?width=1260&size=1.5",
                "Amazon Prime Day Is Good For Shoppers. Just Don’t Expect It to Move the Stock",
                "Amazon Prime Day 2021 is coming. That’s good news for consumers, and investors hope it will be good news for Amazon.com stock. They shouldn’t get their hopes up.\n" +
                        "." +
                        "When is Amazon Prime Day 2021? The company announced that this year’s Prime shopping days will occur on June 21 and 22, promising “two days of epic savings."
        ));
        newsList.add(new ArticleItemViewModel(
                "https://media.npr.org/assets/img/2021/06/02/ap110222114016-68ea525f6a7d45c6cd1bf171727ac94803b0144b-s700-c85.webp",
                "Iran's Largest Navy Ship Sinks In The Gulf Of Oman After Catching Fire",
                "Iran's largest navy vessel caught fire in the Gulf of Oman on Wednesday and sank, according to the Tasnim News Agency.\n" +
                        "." +
                        "A fire broke out on the IS Kharg while the ship was near Iran's port of Jask, southeast of Tehran, according to the Iranian navy. All crew members were able to flee the burning ship and were transferred to safety on the coast. The Kharg — sometimes spelled \"Khark\" — was one of navy's few ships capable of replenishing other ships at sea."
        ));
        newsList.add(new ArticleItemViewModel(
                "https://images.barrons.com/im-346735?width=1260&size=1.5",
                "AMC Stock Continues to Rocket Higher as the Meme Trade Heats Up",
                "AMC Entertainment stock’s meme-fueled run continued on Tuesday after the company said it sold $230.5 million in stock to Mudrick Capital Management. The rally held up even after a report from Bloomberg said the firm promptly sold off its stake at a profit.\n" +
                        "." +
                        "AMC stock (ticker: AMC) closed up 23%, to $32.04, on Tuesday. Fellow meme stock GameStop (GME) was up 12%, to $249.02."
        ));
        newsList.add(new ArticleItemViewModel(
                "https://i5.walmartimages.com/asr/58e0617a-ffb3-419c-9e32-4b696bbc8a2b.a0e79db02d89c463cf38f636ca78ff2b.jpeg",
                "Vizio's 2022 TV lineup includes a 40-inch TV with VRR for less than $250",
                "If you've bought a new console or PC graphics card and need a display upgrade, then keep your eye on Vizio's 2022 TV lineup. While features like automatic game mode switching are fairly common in new TVs, variable refresh rate (VRR) was limited to mostly high-end sets last year. Now, Vizio's 1080p D40f-J TV is going on sale at Walmart for $228, and it can handle VRR at up to 60 FPS so that games like Cyberpunk 2077 still look smooth even when your console starts to chug."
        ));
        newsList.add(new ArticleItemViewModel(
                "https://cbsnews3.cbsistatic.com/hub/i/r/2021/06/01/cf182581-734c-4faa-ae31-9a14efe20f97/thumbnail/620x413/422f6b2fd51b14c0a308e096425614d7/gettyimages-1233221973.jpg",
                "JBS, the world's largest meat supplier, hit by cyberattack",
                "Work stopped at several U.S. meat processing plants after the world's largest meat producer was hit with a major cyberattack. The Brazil-based JBS was forced to cease cattle-slaughtering operations at 13 of its meat processing plants in the U.S. on Tuesday.\n" +
                        "." +
                        "But the company said late Tuesday it had made \"significant progress\" in dealing with the cyberattack and expected the \"vast majority\" of its plants to be operating Wednesday, according to The Associated Press."
        ));
    }
}
