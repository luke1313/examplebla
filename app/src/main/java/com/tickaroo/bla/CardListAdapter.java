package com.tickaroo.bla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tickaroo.bla.model.Model;
import java.util.List;

/**
 * Created by lukasolsen on 06/10/14.
 */
public class CardListAdapter extends BaseAdapter {

  private static final int VIEWTYPE_CARD_ONE = 0;
  private static final int VIEWTYPE_CARD_TWO = 1;
  private static final int VIEWTYPE_CARD_THREE = 2;

  private static final int VIEWTYPE_COUNT = 3;

  private Context context;
  private LayoutInflater inflater;

  private List<Model> list;

  class CardOneViewHolder {

    TextView text;

    public CardOneViewHolder(View view) {

      text = (TextView) view.findViewById(R.id.card_one_text);
    }
  }

  class CardTwoViewHolder {

    TextView text;

    public CardTwoViewHolder(View view) {

      text = (TextView) view.findViewById(R.id.card_two_text);
    }
  }

  class CardThreeViewHolder {

    TextView text;

    public CardThreeViewHolder(View view) {

      text = (TextView) view.findViewById(R.id.card_three_text);
    }
  }

  public CardListAdapter(Context context) {
    this.context = context;
    this.inflater = LayoutInflater.from(context);
  }

  @Override public int getCount() {
    return list == null ? 0 : list.size();
  }

  @Override public Model getItem(int position) {
    return list.get(position);
  }

  @Override public long getItemId(int position) {
    // not needed
    return 0;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    int type = getItemViewType(position);
    if (convertView == null) {
      convertView = createView(type, parent);
    }
    bindView(convertView, position, type);
    return convertView;
  }

  private void bindView(View convertView, int position, int type) {
    switch (type) {
      case VIEWTYPE_CARD_ONE: {
        CardOneViewHolder holder = (CardOneViewHolder) convertView.getTag();
        Model model = getItem(position);
        holder.text.setText(model.getTest());
        break;
      }
      case VIEWTYPE_CARD_TWO: {
        // set views
        break;
      }
      case VIEWTYPE_CARD_THREE: {
        // set views
        break;
      }
    }
  }

  private View createView(int type, ViewGroup parent) {
    switch (type) {
      case VIEWTYPE_CARD_ONE: {
        View view = inflater.inflate(R.layout.card_one, parent, false);
        view.setTag(new CardOneViewHolder(view));
        return view;
      }
      case VIEWTYPE_CARD_TWO: {
        View view = inflater.inflate(R.layout.card_two, parent, false);
        view.setTag(new CardTwoViewHolder(view));
        return view;
      }
      case VIEWTYPE_CARD_THREE: {
        View view = inflater.inflate(R.layout.card_three, parent, false);
        view.setTag(new CardThreeViewHolder(view));
        return view;
      }
    }
    return null;
  }

  public void setItems(List<Model> model) {
    this.list = model;
  }

  @Override public int getItemViewType(int position) {
    Model model = getItem(position);
    if(model instanceof CardOneModel) {
      return VIEWTYPE_CARD_ONE;
    } 
    if(model instanceof CardTwoModel) {
      return VIEWTYPE_CARD_TWO;
    } else {
      return VIEWTYPE_CARD_THREE
    }
  }

  @Override public int getViewTypeCount() {
    return VIEWTYPE_COUNT;
  }
}
